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

let vibes = [];
let vibeApi = 'http://localhost:8080/lib/vibe';

(async() => {
  let resp = await fetch(vibeApi)
  vibes = await resp.json()
  document.querySelector('#vibeTable').innerHTML = VibeListTable(vibes)
})();

const VibeTable = (vibeData) => {
  return `<table>
            <tr>
              <td>${vibeData.id}</td>
              <td>${vibeData.soulId}</td>
              <td>${vibeData.tldr}</td>
              <td>${vibeData.purpose}</td>
            </tr>
          </table>`
}

const VibeListTable = (vibeJSON) => {
  return `<div>
            ${vibeJSON.map(VibeTable).join('')}
          </div>`
}

// let souls = [];
// let soulApi = 'http://localhost:8080/lib/soul';

// (async() => {
//   let resp = await fetch(soulApi);
//   souls = await resp.json();
//   document.querySelector('#soulTable').innerHTML = SoulListTable(souls);
// })();

// const SoulTable = (soulData) => {
//   return `<table>
//             <tr>
//               <td>${soulData.id}</td>
//               <td>${soulData.name}</td>
//             </tr>
//           </table>`
// }

// const SoulListTable = (soulJSON) => {
//   return `<div>
//             ${soulJSON.map(SoulTable).join('')}
//           </div>`
// }

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

    let id = document.createElement("td");
    id.innerHTML = soul.id;
    row.appendChild(id);

    let name = document.createElement("td");
    name.innerHTML = soul.name;
    row.appendChild(name);

    $('#soulTable').append(row);

  }
}
// soul datatable implementation end

populateSoulTable();
