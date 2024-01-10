/* eslint-disable prettier/prettier */
import { Controller, Get, Param } from '@nestjs/common';

@Controller('categories')
export class CategoriesController {
  @Get('idCategory/products/:idProduct')
  getCategory(@Param() { idCategory, idProduct }) {
    return `Producto id ${idProduct}, Categoria id ${idCategory}`;
  }
}
