import { Controller, Get } from '@nestjs/common';
import { AppService } from './app.service';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  getHello(): string {
    return "Mi primer WebService por Get";
  }

  @Get('nuevo')
  getMiPrimerGet1(): string {
    return "Mi primer Get";
  }

  @Get('ruta')
  getMiPrimerGet2(): string {
    return "Mi segundo Get";
  }


}

