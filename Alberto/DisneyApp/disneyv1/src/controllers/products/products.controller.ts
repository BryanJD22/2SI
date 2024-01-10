/* eslint-disable prettier/prettier */
import { Controller,Get, Param, Query,Post, Body, Put } from '@nestjs/common';

@Controller('products')
export class ProductsController {


    @Get()
    getProducts(@Query('limit') limit, 
                @Query('offset') offset){
      return `products limit=> ${limit} offset=>${offset}`            
    }

    
  @Get(':idProduct')
  getProduct(@Param('idProduct') idProduct:number){
    return `product ${idProduct}`
  }

  @Post('ruta')
  create(){
    return {
        message:'crear producto'
    };
  }

  @Post()
  create2(@Body() product:any){
    return {
        product,
        message:'crear producto'
    };
  }

  @Put(':id')
  update(@Param('id') id: number, @Body() product:any){
    return{
        id,
        product
    }
  }

  
  @Put(':id')
  delate(@Param('id') id: number){
    return{
        id,
        
    }
  }


}
