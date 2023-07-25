import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from "reactstrap"
import Base from "../components/Base"
import { useEffect, useState } from "react";
import { signUp } from "../services/userService";

const Signup = () => {

    const [data, setData] = useState({
        name : '', 
        email : '', 
        password : '', 
        about : ''
    })

    const [error, setError] = useState({
        errors : {},
        isError: false
    })

    // handleChange
    const handleChange = (event, fieldName) => {
        setData({...data, [fieldName]: event.target.value});
    }

    // resetting the form
    const resetData = () => {
        setData({
            name : '', 
            email : '', 
            password : '', 
            about : ''
        })
    }

    // submitting the form
    const submitForm = (event) => {
        event.preventDefault();
        console.log(data);

        // data validation

        // server call
        signUp(data).then((res) => {
            console.log(res);
        }).catch((error) => {
            console.log("Error log from signup" + error)
        })

    }

    return (
        <Base>
            <Container>
                <Row className="mt-4">
                    {JSON.stringify(data)}
                    <Col sm={{size:6, offset: 3}}>
                        <Card color="light">
                            <CardHeader>
                                Registration Form
                            </CardHeader>
                            <CardBody>
                                {/* Creating Form */}
                                <Form onSubmit={submitForm}>
                                    <FormGroup>
                                        <Label for="name">Name</Label>
                                        <Input type="text" placeholder="Enter Name" id="name" 
                                        onChange={(e) => handleChange(e, 'name')} value={data.name}></Input>
                                    </FormGroup>
                                    <FormGroup>
                                        <Label for="email">Email</Label>
                                        <Input type="email" placeholder="Enter Email" id="email" 
                                        onChange={(e) => handleChange(e, 'email')} value={data.email}></Input>
                                    </FormGroup>
                                    <FormGroup>
                                        <Label for="password">Password</Label>
                                        <Input type="password" placeholder="Enter Password" id="password" 
                                        onChange={(e) => handleChange(e, 'password')} value={data.password}></Input>
                                    </FormGroup>
                                    <FormGroup>
                                        <Label for="about">About </Label>
                                        <Input type="textarea" placeholder="Enter About" id="about" 
                                        onChange={(e) => handleChange(e, 'about')} value={data.about}></Input>
                                    </FormGroup>
                                    <Container className="text-center">
                                        <Button color="dark">Register</Button>
                                        <Button color="secondary" type="reset" onClick={resetData} className="ms-2">Reset</Button>
                                    </Container>
                                </Form>
                            </CardBody>
                        </Card>
                    </Col>
                </Row>
            </Container>
        </Base>
    )
}

export default Signup