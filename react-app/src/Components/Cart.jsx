const Cart = (props) => {
    const {cartItems, onAdd} = props;

    return(
        <div>
            <h2 className="is-size-3">Cart Items</h2>
            <div> {cartItems.length === 0 && <div>Cart is empty</div> }</div>
            {cartItems.map((item) => (
                <div key={item.id} className="row">
                    <div>{item.name}</div>
                    <div>
                        <button onClick={() => onAdd(item)} className="add">+</button>
                        {/*<button onClick={() => onRemove(item)} className="remove">-</button>*/}
                    </div>
                    <div>
                        {item.qty} x ${item.price.toFixed(2)}
                    </div>
                </div>
            ))}
        </div>
    )

}

export default Cart;