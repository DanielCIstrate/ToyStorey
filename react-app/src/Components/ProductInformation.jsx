import {useEffect, useState} from "react";

const ProductInformation = () => {
    const componentStyle = {marginTop: "20px"};
    const priceStyle = {marginTop: "0px"}
    return (
        <section className="info" style={componentStyle}>
            <div className="container">
                <div className="columns is-vcentered is-multiline">
                    <div className="column is-3-desktop is-size-6-tablet">
                        <h1 className="is-size-3-mobile is-size-1-desktop title">Tricicleta Rosie</h1>
                        <h2 className="is-size-3-mobile is-size-2-desktop subtitle">Tricicleta pentru copii pana in 5 ani</h2>
                        <p>Here comes some description about the product</p>
                    </div>
                    <div className="column is-5-desktop is-size-6-tablet has-text-centered">
                        <img src="http://localhost:8080/api/v1/product/1/image/download" alt="a red tricycle for toddlers" className="px-4"/>
                    </div>
                    <div className="column is-12-tablet is-4-desktop">
                        <div className="is-size-4-desktop mb-4" style={priceStyle}>
                            RON 100
                        </div>
                        <p className="mb-4">Some other text or information here....shipping VAT inclusive or not etc.</p>
                    </div>
                </div>
            </div>
        </section>
    );
}

export default ProductInformation;