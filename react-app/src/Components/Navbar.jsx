import logo from "../assets/Logo.jpg"
import {useState} from "react";

const Navbar = () => {
    const logoStyle = {maxHeight: "20vh"};
    const [navbarMenuAddOnClass, setNavbarMenuAddOnClass] = useState("");
    function toggleNavbarBurgerMenu(event) {
        if (navbarMenuAddOnClass === "") {
            setNavbarMenuAddOnClass("is-active");
        } else {
            setNavbarMenuAddOnClass("");
        }
    }
    return (
        <div className="navbar has-shadow is-white">
            <div className="navbar-brand">
                <a href={"/"} className="navbar-item">
                    <img src={logo} alt="brand logo" style={logoStyle}/>
                </a>

                <a className="navbar-burger" id="burger"
                    onClick={toggleNavbarBurgerMenu}>
                    <span></span>
                    <span></span>
                    <span></span>
                </a>
            </div>

            <div className={ "navbar-menu" + " " + navbarMenuAddOnClass } id="nav-links">
                <div className="navbar-end">
                    <a className="navbar-item">
                        My Account
                    </a>
                    <a className="navbar-item">
                        Shopping Cart (0)
                    </a>
                    <a className="navbar-item">
                        About
                    </a>
                </div>
            </div>
        </div>
    );
}

export default Navbar;