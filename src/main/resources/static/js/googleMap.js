const {Map} = await google.maps.importLibrary("maps");
const {LatLng} = await google.maps.importLibrary("core");
const yearSlider = document.getElementById("yearSlider");
const yearValue = document.getElementById("yearValue");

const map = new Map(document.getElementById("googleMap"), {
    zoom: 0,
    center: {lat: 0, lng: 0},
    mapTypeControl: false,
    fullscreenControl: false,
    streetViewControl: false,
    zoomControl: false,
    keyboardShortcuts: false,
    minZoom: 1,
    restriction: {
        latLngBounds: {
            north: 85,
            south: -85,
            west: -180,
            east: 180,
        }
    },
});
let guessMarker = null;

map.addListener("click", (mapsMouseEvent) => {
    if (guessMarker) {
        guessMarker.setPosition(mapsMouseEvent.latLng);
    } else {
        guessMarker = new google.maps.Marker({
            position: mapsMouseEvent.latLng,
            map: map,
            title: "My Guess!"
        });
    }
});


yearValue.textContent = yearSlider.value;

yearSlider.addEventListener("input", function() {
    yearValue.textContent = this.value;
});

let guessLat;
let guessLng;

function position(mapsMouseEvent) {
    guessLat = mapsMouseEvent.latLng.lat();
    guessLng = mapsMouseEvent.latLng.lng();
}

map.addListener("click", position);

function fetchCoordinates() {
    let guessYear = yearSlider.value;
    fetch("/game", {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({guessLat, guessLng, guessYear})

    }).then(response => {

        window.location.href = response.url;
    });
}


const fetchButton = document.getElementById("fetchButton");

fetchButton.addEventListener("click", () => {
    fetchCoordinates();
});

const expandable = document.getElementById("expandable");
expandable.addEventListener("mouseenter", enlargeFunc);

function enlargeFunc() {
    expandable.style.width = "700px";
    expandable.style.height = "700px";
}

expandable.addEventListener("mouseleave", decrementFunc);

function decrementFunc() {
    expandable.style.width = "150px";
    expandable.style.height = "150px";
}

const container = document.getElementById("container");
const imageZoom = document.getElementById("image-zoom");
let scale = 1;

container.addEventListener("wheel", zoomFunc);
function zoomFunc(event) {
    console.log("zoooooom!");
    event.preventDefault();

    const delta = Math.max(-1, Math.min(1, event.deltaY))

    if (delta > 0) {
        scale -= 0.1;
    } else {
        scale += 0.1;
    }

    imageZoom.style.transform = `scale(${scale})`;
}









