import { PartialType } from "@nestjs/mapped-types";
import { IsString, IsNotEmpty,IsNumber, IsPositive, IsUrl } from "class-validator";

export class CreateProductDto{
    //EXPRESIONES REGULARES DE VALIDACIÓN QUE VIENEN DE LA PROPIA FRAMEWORK
    @IsString({message:"Debes insertar texto.."})
    @IsNotEmpty({message:"No puedes dejar el campo vacio"})
    readonly name: string;


    @IsString()
    @IsNotEmpty()
    readonly description: string;


    @IsNumber()
    @IsNotEmpty()
    @IsPositive()
    readonly price: number;


    @IsNumber()
    @IsPositive()
    @IsNotEmpty()
    readonly stock: number;


    @IsUrl()
    @IsNotEmpty()
    readonly image: string;

}

export class UpdateProductDto extends PartialType(CreateProductDto){
    
}



