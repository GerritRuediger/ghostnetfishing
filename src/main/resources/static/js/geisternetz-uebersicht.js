// Kartenanzeige
document.addEventListener("DOMContentLoaded", function () {
    const map = L.map('map').setView([51, 10], 5);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '© OpenStreetMap'
    }).addTo(map);


    if (typeof geisternetze !== 'undefined') {
        console.log("Geisternetze:", typeof geisternetze)
        geisternetze.forEach(netz => {
            L.marker([netz.standort.breitengrad, netz.standort.laengengrad])
                .addTo(map)
                .bindPopup(
                    `<b>ID:</b> ${netz.id}<br/><b>Status:</b> ${netz.status}<br/><a href="/geisternetz/${netz.id}">Details</a>`
                );
        });
    }

    // Tab-Steuerung
    window.showTab = function (id, event) {
        document.querySelectorAll('.tab-content').forEach(el => el.classList.remove('active'));
        document.querySelectorAll('.tab-btn').forEach(el => el.classList.remove('active'));

        document.getElementById(id).classList.add('active');
        event.target.classList.add('active');

        if (id === 'karte') {
            setTimeout(() => map.invalidateSize(), 200);
        }
    };
});