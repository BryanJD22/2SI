import { Injectable } from '@nestjs/common';
import { Product } from 'src/entities/product.entity';

@Injectable()
export class ProductsService {

    private counterId = 0;
    private products: Product [] = [

        {
            id:1,
            name:'Product 1',
            description: 'oeoeoeoe',
            price:300,
            stock: 20, 
            image: 'http//image.com/456'
    
    
        },

    ];

    findAll(){
        return this.products;
    }

    findOne(id:number){
        return this.products.find((item)=>item.id === id);

    }

    create(products:any){
        this.counterId +=1;
        const newProduct = 
        {
            id: this.counterId,
            ...products,
        };

        this.products.push(newProduct);
        return newProduct;

    }

    update(id: number, products: any){
        const productFound = this.findOne(id);
        if(!productFound){
            return null;
        }
        return productFound;
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
