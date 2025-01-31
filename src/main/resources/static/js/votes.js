let radioButtons = document.getElementsByClassName("my_radio_btn")
radioButtons.item(0).setAttribute("checked", "true")

let movieCards = document.getElementsByClassName("movie_card")

for (let card of movieCards) {
    card.addEventListener("click", (e) => {
        e.currentTarget.children[3].children[0].children.namedItem("movieId").click()
    })
}