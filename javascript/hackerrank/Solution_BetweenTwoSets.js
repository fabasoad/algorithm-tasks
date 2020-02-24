function getTotalX(a, b) {
    let minA = Math.min(...a);
    let minB = Math.min(...b);
    const resA = new Set();
    for (let i = minA; i <= minB; i += minA) {
        if (a.every(el => i % el == 0)) {
            resA.add(i);
        }
    }
    const c = [...resA];
    const nfd = [];
    for (let i = 0; i < c.length; i++) {
        let res = true;
        for (let j = 0; j < b.length; j++) {
            res = res && (b[j] % c[i] == 0);
        }
        if (res) {
            nfd.push(c[i]);
        }
    }
    return nfd.length;
}

console.log(getTotalX([2, 4], [16, 32, 96]));