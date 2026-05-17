document.addEventListener('DOMContentLoaded', function() {
    const submarine = document.getElementById('submarine');
    const luggageCircle = document.getElementById('luggageCircle');

    let isLuggageVisible = false;

    function getReservedRects() {
        return [
            submarine,
            document.querySelector('.symbol-logo-outside'),
            document.querySelector('.sound-toggle-container')
        ].filter(Boolean).map((el) => {
            const rect = el.getBoundingClientRect();
            return {
                left: rect.left - 36,
                right: rect.right + 36,
                top: rect.top - 36,
                bottom: rect.bottom + 36
            };
        });
    }

    function intersectsAny(rect, reservedRects) {
        return reservedRects.some((reserved) => {
            return !(
                rect.right < reserved.left ||
                rect.left > reserved.right ||
                rect.bottom < reserved.top ||
                rect.top > reserved.bottom
            );
        });
    }

    function createSeed(value) {
        let seed = 0;
        for (let i = 0; i < value.length; i += 1) {
            seed = (seed * 31 + value.charCodeAt(i)) >>> 0;
        }
        return seed || 1;
    }

    function nextRandom(seedRef) {
        seedRef.value = (seedRef.value * 1664525 + 1013904223) >>> 0;
        return seedRef.value / 4294967296;
    }

    function positionLuggage() {
        const items = Array.from(luggageCircle.querySelectorAll('.luggage-item'));
        const reservedRects = getReservedRects();
        const placedRects = [];
        const margin = window.matchMedia('(max-width: 768px)').matches ? 22 : 36;
        const seedRef = {
            value: createSeed(items.map((item) => item.dataset.lid || item.dataset.title || '').join('|'))
        };

        items.forEach((item, index) => {
            const itemWidth = item.offsetWidth || 100;
            const itemHeight = item.offsetHeight || 120;
            let left = margin;
            let top = margin;
            let found = false;

            for (let attempt = 0; attempt < 160; attempt += 1) {
                left = margin + nextRandom(seedRef) * Math.max(1, window.innerWidth - itemWidth - margin * 2);
                top = margin + nextRandom(seedRef) * Math.max(1, window.innerHeight - itemHeight - margin * 2);

                const candidate = {
                    left,
                    right: left + itemWidth,
                    top,
                    bottom: top + itemHeight
                };

                if (!intersectsAny(candidate, reservedRects) && !intersectsAny(candidate, placedRects)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                const column = index % Math.max(1, Math.floor(window.innerWidth / (itemWidth + margin)));
                const row = Math.floor(index / Math.max(1, Math.floor(window.innerWidth / (itemWidth + margin))));
                left = margin + column * (itemWidth + margin);
                top = margin + row * (itemHeight + margin);
            }

            item.style.left = `${left}px`;
            item.style.top = `${top}px`;
            item.style.transform = 'none';
            item.classList.add('active');
            placedRects.push({
                left,
                right: left + itemWidth,
                top,
                bottom: top + itemHeight
            });
        });
    }

    // 잠수함 클릭 이벤트
    submarine.addEventListener('click', function() {
        if (!isLuggageVisible) {
            luggageCircle.classList.add('show');
            isLuggageVisible = true;
            positionLuggage();
        } else {
            luggageCircle.classList.remove('show');
            isLuggageVisible = false;
        }
    });

    window.addEventListener('resize', function() {
        if (isLuggageVisible) {
            positionLuggage();
        }
    });

    // 가방 클릭은 목록 화면에 머무른다.
    document.addEventListener('click', function(e) {
        if (e.target.closest('.luggage-item')) {
            e.stopPropagation();
        }
    });
});
