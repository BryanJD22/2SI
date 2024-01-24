import { Inject, Injectable } from '@nestjs/common';

@Injectable()
export class AppService {
  constructor(
    @Inject('API_KEY') private apiKey: String,
    @Inject('TASK') private tasks: any[],

  ){}


  getHello(): string {
    console.log(this.tasks);
    return `Hello World! ${this.apiKey}`;
  }
}
