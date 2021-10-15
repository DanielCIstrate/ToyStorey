import './App.css';
import 'bulma/css/bulma.min.css';
import Navbar from "./Components/Navbar";
import ProductInformation from "./Components/ProductInformation";
import DeliveryDetails from "./Components/DeliveryDetails";


function App() {
  return (
    <div className="App">
      <Navbar/>
      <ProductInformation/>
      <DeliveryDetails/>
    </div>
  );
}

export default App;
