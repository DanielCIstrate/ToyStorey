import './App.css';
import 'bulma/css/bulma.min.css';
import Navbar from "./Components/Navbar";
import ProductInformation from "./Components/ProductInformation";


function App() {
  return (
    <div className="App">
      <Navbar/>
      <ProductInformation/>
    </div>
  );
}

export default App;
