/**
 * read and generate table of data from /thought servlet 
 */
let uri = 'http://localhost:8080/lib/thought';
let thoughts = [];


async function readThoughts() {
  let resp = await fetch(uri);
  thoughts = await resp.json();
  console.log(thoughts);
}

readThoughts();

function generateThoughtTable() {
  function generateTableHead(table, data) {
    let thead = table.createTHead();
    let row = thead.insertRow();
    for(let key of data) {
      let th = document.createElement("th");
      let text = document.createTextNode(key);
      th.appendChild(text);
      row.appendChild(th);
    }
  }

  function generateTable(table, data) {
    for(let element of data) {
      let row = table.insertRow();
      for(key in element) {
        let cell = row.insertCell();
        let text = document.createTextNode(element[key]);
        cell.appendChild(text);
      }
    }
  }

  let table = document.getElementById("thoughtTable");
  let data = Object.keys(thoughts[0]);
  generateTable(table, thoughts);
  generateTableHead(table, data);
}