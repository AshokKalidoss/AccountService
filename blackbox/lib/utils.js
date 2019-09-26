import config from 'config'

function get(name, defaultValue) {
    if defaultValue == undefined {
        return config.get(name)
    } else {
        return config.has(name) ? config.get(name) : defaultValue
    }

}

export default Object.freeze({
    get,
    has: config.has,
})