document.getElementById("system").style.background = "yellow";
var code = document.querySelector("code");
console.log(code)

// arrow function practice
let hello = () => "Hello, World!";
console.log(hello());

function hello2() {
    return "Hello, World2!";
}
console.log(hello2());

// promise practice
let p = new Promise((resolve, reject) => {
    let a = 1+2;
    if (a == 2) {
        resolve('Success');
    } else {
        reject('Failed');
    }
})

p.then(function(message) {
    console.log(message);
}).catch((message) => console.log(message));

// callback practice
function functwo(y, callback) {
    callback(y);
}

functwo(10, function(x) {
    console.log("x = " + x);
});

// imediately invokes function expression practice

(function(){console.log("i'm an iife!")})();

// template literal practice

console.log(`first line
second line
third line`);

var x = 10;
var y = 20;
console.log(`${hello2()}, here's x: ${x}`);

// tagged template practice



// OOP in JavaScript practice

const Book = function(t, a) {
    let title = t; 
    let author = a; 
    
    return {
       summary : function() { 
         console.log(`${title} written by ${author}.`);
       } 
    }
 }
 const book1 = new Book('Hippie', 'Paulo Coelho');
 book1.summary(); // Returns Hippie written by Paulo Coelho.

 // prototypical inheritance practce

 let animal = {
    eats: true,
  walk() {
      console.log("Animal walk");
    }
  };
  let rabbit = {
    jumps: true,
    __proto__: animal	// sets animal to be a prototype of rabbit.
  };
  
  // we can find both properties in rabbit now:
  console.log( rabbit.eats ); // true 
  console.log( rabbit.jumps ); // true
  // walk is taken from the prototype
  rabbit.walk(); // Animal walk