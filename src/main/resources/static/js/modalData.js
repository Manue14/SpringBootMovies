let deleteButtons = document.getElementsByClassName("my-delete-button")
let modalBody = document.getElementById("modal-body")
let deleteUserLink = document.getElementById("delete-user-link")

for (let button of deleteButtons) {
    button.addEventListener("click", (e) => {
        passDataToModal(e.currentTarget)
    })
}

function passDataToModal(element) {
    let userId = element.getAttribute("data-user-id")
    let link = "/user/delete/" + userId
    modalBody.innerHTML = "Are you sure you want to delete the user with id " + userId + "?"
    deleteUserLink.setAttribute("href", link)
}