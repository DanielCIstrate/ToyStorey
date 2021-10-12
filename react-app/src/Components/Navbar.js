import logo from "../assets/Logo.jpg"

const Navbar = () => {
    const logoStyle = {maxHeight: "20vh"}
    return (
        <div className="navbar">
            <div className="navbar-brand">
                <a href={"/"} className="navbar-item">
                    <img src={logo} alt="brand logo" style={logoStyle}/>
                </a>
            </div>
        </div>
    );
}

export default Navbar;