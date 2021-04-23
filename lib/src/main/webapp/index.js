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

let souls = [];
let soulApi = 'http://localhost:8080/lib/soul';

(async() => {
  let resp = await fetch(soulApi);
  souls = await resp.json();
  document.querySelector('#soulTable').innerHTML = SoulListTable(souls);
})();

const SoulTable = (soulData) => {
  return `<table>
            <tr>
              <td>${soulData.id}</td>
              <td>${soulData.name}</td>
            </tr>
          </table>`
}

const SoulListTable = (soulJSON) => {
  return `<div>
            ${soulJSON.map(SoulTable).join('')}
          </div>`
}