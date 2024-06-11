var input = require('fs').readFileSync('/dev/stdin').toString();

if (input.indexOf('D2') != -1 || input.indexOf('d2') != -1) {
    console.log('D2');
}
else {
    console.log('unrated');
}