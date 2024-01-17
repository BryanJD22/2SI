/* eslint-disable prettier/prettier */
import { Controller, Get, Param, Query, Post, Body, Put, ParseIntPipe } from '@nestjs/common';
import { Product } from 'src/entities/product.entity';
import { ProductsService } from 'src/services/products/products.service';

@Controller('products')
export class ProductsController {

  constructor (private productService: ProductsService){
    
  }


  @Get()
  getProducts(@Query('limit') limit, @Query('offset') offset) {
    //return `products limit=> ${limit} offset=>${offset}`;
    return this.productService.findAll();
  }

  @Get(':idProduct')
  getProduct(@Param('idProduct', ParseIntPipe) idProduct: number) {
    //return `product ${idProduct}`;
    
    return this.productService.findOne(+idProduct);

  }

  @Post('ruta')
  create(@Body() newProduct: Product) { 
  /*
   return {
      message: 'crear producto',
    };
    */
    return this.productService.create(newProduct);
  }

  @Post()
  create2(@Body() product: any) {
    /*return {
      product,
      message: 'crear producto',
    };*/
    return this.productService.create(product);
  }

  @Put(':id')
  update(@Param('id') id: string, @Body() product: Product) {
    /*return {
      id,
      product,
    };*/

    return this.productService.update(+id,product);
  }

  @Put(':id')
  delate(@Param('id') id: string) {
    /*return {
      id,
    };*/

    return this.productService.delete(+id);
  
  }
}
