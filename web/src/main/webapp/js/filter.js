function onlyAudioBooks(kind) {
  location.replace('/book-list?part=0&hasAudio=1&kind=' + kind)
}

function allBooks(kind) {
  location.replace('/book-list?part=0&hasAudio=0&kind=' + kind)
}

function kind(number, hasAudio) {
  if (number === 1) {
    location.replace('/book-list?part=0&hasAudio=' + hasAudio + '&kind=1')
  }
  if (number === 2) {
    location.replace('/book-list?part=0&hasAudio=' + hasAudio + '&kind=2')
  }
  if (number === 3) {
    location.replace('/book-list?part=0&hasAudio='+ hasAudio + '&kind=3')
  }
}
