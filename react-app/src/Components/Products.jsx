import {useEffect, useState} from "react";
import axios from 'axios';
import ProductCard from "./ProductCard";

const Products = () => {
    const [products, setProducts] = useState([]);
    const fetchProducts=() => {
        axios.get('http://localhost:8080/products')
            .then((response) => {
                setProducts(response.data)
            })
    }


    useEffect(() => {
        fetchProducts();
    }, [])

    return products.map((product,index) => {
        return (
            <div key={index} className="column is-one-third-desktop is-half-tablet">
                <ProductCard
                    img={`http://localhost:8080/api/v1/product/${product.id}/image/download`}
                    name={product.name}
                    price={product.price}
                />
            </div>
        );
    });


}

export default Products;