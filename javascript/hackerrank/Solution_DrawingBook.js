// https://www.hackerrank.com/challenges/drawing-book/problem
function assertEquals(actual, expected) {
    if (actual !== expected) {
        throw `${actual} !== ${expected}`;
    }
}

function pageCount(n, p) {
    if (n === p || p === 1) return 0;
    if (p === (n / 2)) return Math.floor(p / 2);
    const diff = n - p;
    if (diff > p) {
        return Math.floor(p / 2);
    }
    return (n % 2 == 0 ? Math.ceil : Math.floor)(diff / 2);
}

assertEquals(0, pageCount(5, 4));
assertEquals(1, pageCount(6, 2));
assertEquals(0, pageCount(1, 1));
assertEquals(0, pageCount(100, 1));
assertEquals(1, pageCount(7, 3));
assertEquals(1, pageCount(7, 4));
assertEquals(1, pageCount(6, 3));
assertEquals(1, pageCount(6, 5));
