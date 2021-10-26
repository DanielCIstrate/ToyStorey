import {useEffect, useState} from "react";
import axios from 'axios';
import ProductCard from "./ProductCard";

const Products = (props) => {

    return props.products.map((product,index) => {
        return (
            <div key={index} className="column is-one-third-desktop is-half-tablet">
                <ProductCard
                    img={`http://localhost:8080/api/v1/product/${product.id}/image/download`}
                    product = {product}
                    name = {product.name}
                    price = {product.price}
                    onAdd = {props.onAdd}
                />
            </div>
        );
    });


}

export default Products;