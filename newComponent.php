<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * CakePHP Component
 * @author jean
 */
class newComponentComponent extends Object {

    public $components = array();
    public $settings = array();

    function initialize(&$controller, $settings) {
        $this->controller = $controller;
        $this->settings = $settings;
    }

    function startup(&$controller) {
        
    }

    function beforeRender() {
        
    }

    function beforeRedirect() {
        
    }

    function shutDown(&$controller) {
        
    }

}
