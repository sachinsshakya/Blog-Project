import CustomNavbar from "./CustomNavbar";

const Base = ({title = "Welcome to Our Website", children}) => {
    return (
        <div className="container-fluid p-0 m-0">
            <CustomNavbar></CustomNavbar>

            {children}

            {/* <h1>This is footer</h1> */}
        </div>
    )
}

export default Base;