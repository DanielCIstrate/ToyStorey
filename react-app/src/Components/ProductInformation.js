const ProductInformation = () => {
    const componentStyle = {marginTop: "20px"};
    const priceStyle = {marginTop: "0px"}
    return (
        <section className="info" style={componentStyle}>
            <div className="container">
                <div className="columns is-vcentered">
                    <div className="column is-3">
                        <h1 className="is-size-1 title">Tricicleta Rosie</h1>
                        <h2 className="is-size-4 subtitle">Tricicleta pentru copii pana in 5 ani</h2>
                        <p>Here comes some description about the product</p>
                    </div>
                    <div className="column is-5 has-text-centered">
                        <img src="/img/toy_image_2.jpg" alt="a red tricycle for toddlers" className="px-4"/>
                    </div>
                    <div className="column is-4">
                        <div className="is-size-4 mb-4" style={priceStyle}>
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