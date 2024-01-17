import { Injectable, NotFoundException } from '@nestjs/common';
import { CreateProductDto, UpdateProductDto } from 'src/dto/product.dto';
import { Product } from 'src/entities/product.entity';
import { productsMocks } from 'src/mocks/product.mocks';

@Injectable()
export class ProductsService {

    private counterId = 0;
    private products: Product [] =  productsMocks;
    
    /*private products: Product [] =  [    esto es provicional, traeremos de otro lado el api

       /{
            id:1,
            name:'Product 1',
            description: 'oeoeoeoe',
            price:300,
            stock: 20, 
            image: 'http//image.com/456'
    
    
        },

    ];*/

    findAll(){
        return this.products;
    }

    findOne(id:number){
        //return this.products.find((item)=>item.id === id);
        const product = this.products.find(
            (item)=>
                item.id === id
            
        )
        if(!product){
            //throw 'Bj error';
            throw new NotFoundException(`Product #${id} not found`)
        }
        return product
    }

    create(products: CreateProductDto){
        this.counterId +=1;
        const newProduct = 
        {
            id: this.counterId,
            ...products,
        };

        this.products.push(newProduct);
        return newProduct;

    }

    update(id: number, updateProduct: UpdateProductDto){
        const productFound = this.findOne(id);
        let message = '';
        if(productFound){
            const index = this.products.findIndex(
                (item)=>
                    item.id === id
                
            );
            //this.products[index] = updateProduct;
            // MERGE
            this.products[index] = {
                ...productFound,
                ...updateProduct,
           }
           message = 'Product updated';
        }else{
            message = 'Product not found';
        }
        return message;
        
    }

    delete(id: number){
        const productFound = this.products.findIndex(
            (item) => item.id === id

        );

        let message = '';
        if(productFound > 0){
            this.products.splice(productFound,1);
            message = 'product deleted'
        }else{
            message = 'product not found'
        }
        return message;

    }


}
