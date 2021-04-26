// thought datatable implementation begin
let thoughtApi = 'http://localhost:8080/lib/thought';

let getThoughts = async function() {
  let resp = await fetch(thoughtApi);
  let thoughts = await resp.json();
  return thoughts;
}

let populateThoughtTable = async function() {
  let thoughts = await getThoughts();
  for(const thought of thoughts) {
    let row = document.createElement("tr");

    let thoughtId = document.createElement("td");
    thoughtId.innerHTML = thought.thoughtId;
    row.appendChild(thoughtId);
    
    let thoughtTldr = document.createElement("td");
    thoughtTldr.innerHTML = thought.thoughtTldr;
    row.appendChild(thoughtTldr);
    
    let thoughtVibeId = document.createElement("td");
    thoughtVibeId.innerHTML = thought.thoughtVibeId;
    row.appendChild(thoughtVibeId);

    let thoughtLocation = document.createElement("td");
    thoughtLocation.innerHTML = thought.thoughtLocation;
    row.appendChild(thoughtLocation);

    let thoughtFrame = document.createElement("td");
    thoughtFrame.innerHTML = thought.thoughtFrame;
    row.appendChild(thoughtFrame);

    $('#thoughtTable').append(row);

  }
}
// thought datatable implementation end

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
    
    let vibeSoulId = document.createElement("td");
    vibeSoulId.innerHTML = vibe.vibeSoulId;
    row.appendChild(vibeSoulId);

    let vibePurpose = document.createElement("td");
    vibePurpose.innerHTML = vibe.vibePurpose;
    row.appendChild(vibePurpose);

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

populateThoughtTable();
populateVibeTable();
populateSoulTable();