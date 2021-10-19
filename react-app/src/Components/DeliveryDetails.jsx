import {useState} from "react";
import MessageBox from "./MessageBox";

const DeliveryDetails = () => {
    const [activeTab,setActiveTab] = useState(0);
    const activeProperty = "is-active";
    const hiddenProperty = "is-hidden"

    function handleClickActiveTab(value) {
        const newActiveTab = value;
        console.log(newActiveTab);
        setActiveTab(newActiveTab);
    }

    return (
        <section>
            <div className="container">
                <div className="columns is-8 is-variable">
                    <div className="column is-7-tablet">
                        <div className="tabs is-boxed">
                            <ul>
                                <li onClick={() => handleClickActiveTab(0)} className={activeTab === 0 ? activeProperty : "" } >
                                    <a>
                                      Product Details
                                    </a>
                                </li>
                                <li onClick={() => handleClickActiveTab(1)} className={activeTab === 1 ? activeProperty : "" }>
                                    <a>
                                        Delivery Details
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div className="px-2" id="tab-content">
                            <div id="product-details" className={activeTab == 0 ? hiddenProperty : ""}>
                                <h3 className="is-size-5 title">Product Details</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. A animi cupiditate deleniti dolorum, facere harum libero molestiae pariatur quam temporibus.</p>
                            </div>
                            <div id="delivery-information" className={activeTab == 1 ? hiddenProperty : ""}>
                                <h3 className="is-size-5 title">Delivery Information</h3>
                                <p>Some other text will go here. Some other text will go here. Some other text will go here. Some other text will go here. Some other text will go here. Some other text will go here. Some other text will go here.</p>
                            </div>
                        </div>
                    </div>
                    <div className="column is-5-tablet">
                        <MessageBox/>
                    </div>

                </div>
            </div>
        </section>
    );

}

export default DeliveryDetails;