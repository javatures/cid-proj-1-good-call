let thoughts = [];
let thoughtApi = 'http://localhost:8080/lib/thought';

 (async() => {
  let resp = await fetch(thoughtApi)
  thoughts = await resp.json()
  document.querySelector('#thoughtTable').innerHTML = ThoughtListTable(thoughts)
})();

function ThoughtDiv(thoughtData) {
  return `<div>
            <h2>${thoughtData.tldr}</h2>
            <h3>${thoughtData.vibe.id}</h3>
            <h3>${thoughtData.location}</h3>
            <h3>${thoughtData.frame}</h3>
          </div>`
}

function ThoughtListDiv(thoughtJSON) {
  return `<div>
            ${thoughtJSON.map(ThoughtDiv).join('')}
          </div>`
}

function ThoughtTable(thoughtData) {
  return `<table>
            <tr>
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