#RippleLoader

##Simple Android Library to create a ripple loader while doing some blocking operation. Inspired from uber loader that comes when we book a cab.

##Usage

###Initializing (in Activity File)
```
    RippleLoader rippleLoader = new RippleLoader(this);
```

###To start loading
```
    rippleLoader.startLoading()
```

###To stop
```
    rippleLoader.stop()
```
