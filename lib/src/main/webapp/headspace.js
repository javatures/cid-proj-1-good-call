// vibe datatable implementation begin
let vibeApi = 'http://localhost:8080/lib/vibe';

let getVibes = async function() {
  let resp = await fetch(vibeApi);
  let vibes = await resp.json();
  return vibes;
}

let populateVibeTable = async function() {
  let vibes = await getVibes();
  for(const vibe of vibes) {
    let row = document.createElement("tr");

    let vibeId = document.createElement("td");
    vibeId.innerHTML = vibe.vibeId;
    row.appendChild(vibeId);

    let vibeTldr = document.createElement("td");
    vibeTldr.innerHTML = vibe.vibeTldr;
    row.appendChild(vibeTldr);

    $('#vibeTable').append(row);

  }
}
// vibe datatable implementation end

// soul datatable implementation begin
let soulApi = 'http://localhost:8080/lib/soul';

let getSouls = async function() {
  let resp = await fetch(soulApi);
  let souls = await resp.json();
  return souls;
}

let populateSoulTable = async function() {
  let souls = await getSouls();
  for(const soul of souls) {
    let row = document.createElement("tr");

    let soulId = document.createElement("td");
    soulId.innerHTML = soul.soulId;
    row.appendChild(soulId);

    let soulName = document.createElement("td");
    soulName.innerHTML = soul.soulName;
    row.appendChild(soulName);

    $('#soulTable').append(row);

  }
}
// soul datatable implementation end

populateVibeTable();
populateSoulTable();