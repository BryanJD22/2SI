/* eslint-disable prettier/prettier */
const myName: string = 'Nico';
const myAge: number = 12;
myName.charAt(0);

//Formas de hacer una funcion

function suma1(a: number, b: number): number {
  return a + b;
}
suma1(5, 7);

const suma2 = (a: number, b: number) => {
  return a + b;
};
// suma(2, 'a');
suma2(2, 2);

const suma3 = (a: number, b: string) => {
  return a + b;
};

suma3(3, '4');

class Persona {
  private age: number;
  private name: string;
  private adr: string;

  public getAge(): number {
    return this.age;
  }

  public setAge(age: number): void {
    this.age = age;
  }

  public getName(): string {
    return this.name;
  }

  public setName(name: string): void {
    this.name = name;
  }

  public getAdr(): string {
    return this.adr;
  }

  public setAdr(adr: string): void {
    this.adr = adr;
  }

  constructor(age: number, name: string) {
    this.age = age;
    this.name = name;
  }

  public getSummary(): string {
    return this.age + ' ' + this.name;
  }
}

const persona = new Persona(30, 'Juan Pérez');
console.log(persona.getSummary()); // Salida: 30 Juan Pérez
