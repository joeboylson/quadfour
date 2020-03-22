const toggleModal = () => {
    const searchModal = document.getElementById('search-modal');
    const searchModalContent = document.getElementById('search-modal-content');

    if (searchModal.classList.contains('open')) {
        searchModal.classList.remove('open')
    } else {
        searchModal.classList.add('open')
    }

    if (searchModalContent.classList.contains('open')) {
        searchModalContent.classList.remove('open')
    } else {
        searchModalContent.classList.add('open')
    }

}