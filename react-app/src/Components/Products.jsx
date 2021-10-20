import {useEffect, useState} from "react";
import axios from 'axios';

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
            <div key={index}>
                <h1>{product.id}</h1>
                <h2>{product.name}</h2>
                {
                    product.id ? (<img src = {`http://localhost:8080/api/v1/product/${product.id}/image/download`}/>) : <h4>No image present</h4>
                }
            </div>
        );
    });


}

export default Products;