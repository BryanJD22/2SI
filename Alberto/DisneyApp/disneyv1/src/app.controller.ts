/* eslint-disable prettier/prettier */
import { Controller, Get } from '@nestjs/common';
import { AppService } from './app.service';
import { Param } from '@nestjs/common';
import { Query } from '@nestjs/common';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}



 






  @Get()
  getHello(): string {
    return 'Mi primer WebService por Get';
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

