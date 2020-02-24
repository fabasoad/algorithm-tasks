function catAndMouse(x, y, z) {
    const x1 = Math.abs(z - x);
    const y1 = Math.abs(z - y);
    return x1 < y1 ? 'Cat A' : (x1 > y1 ? 'Cat B' : 'Mouse C');
}

const r1 = catAndMouse(1, 2, 3);
const r2 = catAndMouse(1, 3, 2);
console.log(r1);
console.log(r2);