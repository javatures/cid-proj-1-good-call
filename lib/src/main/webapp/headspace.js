let thoughts = [];
let thoughtApi = 'http://localhost:8080/lib/thought';

 (async() => {
  let resp = await fetch(thoughtApi)
  thoughts = await resp.json()
  document.querySelector('#thoughtTable').innerHTML = ThoughtListTable(thoughts)
})();

function ThoughtTable(thoughtData) {
  return `<table>
            <tr>
              <td>${thoughtData.id}</td>
              <td>${thoughtData.tldr}</td>
              <td>${thoughtData.vibe.id}</td>
              <td>${thoughtData.location}</td>
              <td>${thoughtData.frame}</td>
            </tr>
          </table>`
}

function ThoughtListTable(thoughtJSON) {
  return `<div>
            ${thoughtJSON.map(ThoughtTable).join('')}
          </div>`
}

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

    let id = document.createElement("td");
    id.innerHTML = vibe.id;
    row.appendChild(id);

    let tldr = document.createElement("td");
    tldr.innerHTML = vibe.tldr;
    row.appendChild(tldr);

    $('#vibeTable').append(row);

  }
}
// vibe datatable implementation end

// soul datatable implementation begin
// let soulApi = 'http://localhost:8080/lib/soul';

// let getSouls = async function() {
//   let resp = await fetch(soulApi);
//   let souls = await resp.json();
//   return souls;
// }

// let populateSoulTable = async function() {
//   let souls = await getSouls();
//   for(const soul of souls) {
//     let row = document.createElement("tr");

//     let id = document.createElement("td");
//     id.innerHTML = soul.id;
//     row.appendChild(id);

//     let name = document.createElement("td");
//     name.innerHTML = soul.name;
//     row.appendChild(name);

//     $('#soulTable').append(row);

//   }
// }
// soul datatable implementation end

populateVibeTable();
