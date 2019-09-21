function onlyAudioBooks() {
location.replace('/book-list?part=0&hasAudio=1')
}
function allBooks() {
location.replace('/book-list?part=0&hasAudio=0')
}