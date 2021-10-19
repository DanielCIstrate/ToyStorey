import './App.css';
import 'bulma/css/bulma.min.css';
import Navbar from "./Components/Navbar";
import ProductInformation from "./Components/ProductInformation";
import DeliveryDetails from "./Components/DeliveryDetails";
import MessageBox from "./Components/MessageBox";
import {useState, useEffect} from "react";


function App() {
    const [product,setProduct] = useState([]);
    // const fetchProduct = async() => {
    //     await fetch("http://localhost:8080/products")
    //         .then(response => response.json())
    //         .then(receiveData => setProduct(receiveData))
    // }
    // useEffect(() => {fetchProduct();},[])


  return (
    <div className="App">
      <Navbar/>
      <ProductInformation/>
      <DeliveryDetails/>

    </div>
  );
}

export default App;
