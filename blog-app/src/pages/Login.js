import Base from "../components/Base"
import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from "reactstrap"

const Login = () => {
    return (
        <Base>
            <Container>
                <Row className="mt-4">
                    <Col sm={{size:6, offset: 3}}>
                        <Card color="light">
                            <CardHeader>
                                Login Form
                            </CardHeader>
                            <CardBody>
                                {/* Creating Form */}
                                <Form>
                                    <FormGroup>
                                        <Label for="email">Email</Label>
                                        <Input type="email" placeholder="Enter Email" id="email"></Input>
                                    </FormGroup>
                                    <FormGroup>
                                        <Label for="password">Password</Label>
                                        <Input type="password" placeholder="Enter Password" id="password"></Input>
                                    </FormGroup>
                                    <Container className="text-center">
                                        <Button color="dark">Login</Button>
                                        <Button color="secondary" type="reset" className="ms-2">Reset</Button>
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

export default Login