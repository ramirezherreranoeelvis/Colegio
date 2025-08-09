echo "✅ Iniciando submódulos..."
git submodule update --init --recursive

echo "🔄 Cambiando cada submódulo a la rama main y actualizando..."
git submodule foreach '
  echo "➡️ Procesando $name"
  git fetch origin
  git checkout main || echo "⚠️ No se pudo hacer checkout a main en $name"
  git pull origin main || echo "⚠️ No se pudo hacer pull en $name"
'

echo "✅ Submódulos actualizados al último commit de main"