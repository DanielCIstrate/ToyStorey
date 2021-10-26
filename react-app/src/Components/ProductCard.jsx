
const ProductCard = (props) => {
    return (
            <div className="card">
                <div className="card-image has-text-centered">
                    <figure className="image is-128-128 is-inline-block">
                        <img src={props.img} alt="placeholder image"/>
                    </figure>
                </div>
                <div className="card-content">
                    <p className="title is-size-3 is-vcentered">
                        {props.name}
                    </p>
                    <p className="is-size-3 has-text-weight-bold has-text-danger">{props.price} Lei</p>
                </div>
                <button onClick={() => props.onAdd(props.product)} className="button is-primary mt-3 mb-6">Add to cart</button>
            </div>
    )
}

export default ProductCard;