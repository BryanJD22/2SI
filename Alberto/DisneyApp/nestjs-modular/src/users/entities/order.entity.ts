import { Product } from "src/products/entities/product.entity";
// import { Product } from "./../../entities/product.entity";
import { User } from "./user.entity";


export class Order{
  date: Date;
  user: User;
  products: Product[];
}
