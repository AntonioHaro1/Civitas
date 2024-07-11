#encoding UTF-8

class Parcela

  #@@factoral_alquiler_calle = 1.0
  #@@factoral_alquiler_casa = 1.0
  #@@factoral_alquiler_hotel = 4.0

  @factoral_alquiler_calle = 1.0
  @factoral_alquiler_casa = 1.0
  @factoral_alquiler_hotel = 4.0

  def initialize(nombre, precio_compra, precio_edificar, precio_alquiler_base)
    @nombre = nombre
    @precio_compra = precio_compra
    @precio_edificar = precio_edificar
    @precio_alquiler_base = precio_alquiler_base
    @num_casas = 0
    @num_hoteles = 0
  end

  def nombre
    @nombre
  end

  def self.factoral_alquiler_calle
    @factoral_alquiler_calle
  end

  def self.factoral_alquiler_casa
    @factoral_alquiler_casa
  end

  def self.factoral_alquiler_hotel
    @factoral_alquiler_hotel
  end

  def precio_compra
    @precio_compra
  end

  def precio_edificar
    @precio_edificar
  end

  def num_casas
    @num_casas
  end

  def num_hoteles
    @num_hoteles
  end

  def get_precio_alquiler_completo
    #(@precio_alquiler_base * @@factoral_alquiler_calle) * (@@factoral_alquiler_casa + @num_casas + @num_hoteles * @@factoral_alquiler_hotel)
    factoral_alquiler_casa = Parcela.factoral_alquiler_casa
    factoral_alquiler_calle = Parcela.factoral_alquiler_calle
    factoral_alquiler_hotel = Parcela.factoral_alquiler_hotel

    (@precio_alquiler_base * factoral_alquiler_calle) * (factoral_alquiler_casa + @num_casas + @num_hoteles * factoral_alquiler_hotel)
  end

  def construir_casa
    @num_casas+=1
    true
  end

  def construir_hotel
    @num_hoteles+=1
    true
  end

end

p1 = Parcela.new("Parcela1", 1000, 200, 100)
p2 = Parcela.new("Parcela2", 2000, 500, 350)

p1.construir_casa
p1.construir_casa

puts 'El precio de alquiler completo de la parcela 1 es ' + p1.get_precio_alquiler_completo.to_s

p2.construir_hotel

puts 'El precio de alquiler completo de la parcela 2 es ' + p2.get_precio_alquiler_completo.to_s