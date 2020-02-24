function sockMerchant(n, ar) {
    let counter = 0;
    const map = new Map();
    for (const sock of ar) {
        if (map.has(sock)) {
            counter--;
            map.delete(sock);
        } else {
            counter++;
            map.set(sock, true);
        }
    }
    return (ar.length - counter) / 2;
}

const res = sockMerchant(9, [10, 20, 20, 10, 10, 30, 50, 10, 20]);
console.log(res);